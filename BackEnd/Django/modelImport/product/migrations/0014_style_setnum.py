# Generated by Django 4.1.7 on 2023-06-06 09:35

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("product", "0013_rename_imgurl_style_tagurl"),
    ]

    operations = [
        migrations.AddField(
            model_name="style",
            name="setNum",
            field=models.IntegerField(default=1),
            preserve_default=False,
        ),
    ]
