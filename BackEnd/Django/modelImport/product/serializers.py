from rest_framework import serializers
from .models import Style, Emoji
class StyleSerializer(serializers.ModelSerializer):
    img = serializers.ImageField(use_url=True)

    class Meta:
        model = Style
        fields = '__all__'


class EmojiSerializer(serializers.ModelSerializer):
    emoji = serializers.ImageField(use_url=True)

    class Meta:
        model = Emoji
        fields = '__all__'