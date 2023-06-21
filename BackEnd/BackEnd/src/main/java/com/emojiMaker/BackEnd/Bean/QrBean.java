package com.emojiMaker.BackEnd.Bean;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.apache.catalina.manager.StatusTransformer.setContentType;
import static org.springframework.web.servlet.function.DefaultEntityResponseBuilder.DefaultEntityResponse.getContentType;

@Component
public class QrBean {
    public QrCodeView() {
        setContentType("image/png; charset=UTF-8");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        response.setHeader("Content-Transfer-Encoding", "binary");

        OutputStream outputStream = response.getOutputStream();

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String content = (String) model.get("content");
        //한글 데이터 처리
        content = new String(content.getBytes(StandardCharsets.UTF_8), "ISO-8859-1");
        //QR 코드 생성 및 출력
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 100, 100);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
        outputStream.flush();
    }
}
