from django.db import models


class Product(models.Model):
    name = models.CharField(max_length=70)
    price = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return self.name


class Style(models.Model):
    requestId = models.CharField(max_length=50, null=False)
    tagName = models.CharField(max_length=50, null=False)
    tagUrl = models.CharField(max_length=256, null=False)
    img = models.BinaryField(null=False)
    setNum = models.IntegerField(null=False)
    class Meta:
        db_table = 'style'


class Emoji(models.Model):
    requestId = models.CharField(max_length=50, null=False)
    emojiRequestId = models.CharField(max_length=50, null=False, default="emojiRequestId")
    tagName = models.CharField(max_length=50, null=False)
    emojiTag = models.CharField(max_length=50, null=False)
    emojiUrl = models.CharField(max_length=256, null=False)
    emoji = models.BinaryField(null=False)
    setNum = models.IntegerField(null=False)

    class Meta:
        db_table = "emoji"
