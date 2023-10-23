from django.contrib import admin

from product.models import Product, Style, Emoji

# Register your models here.
admin.site.register(Product)
admin.site.register(Style)
admin.site.register(Emoji)