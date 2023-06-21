"""modelImport URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path

from product.views import *

urlpatterns = [
    path("admin/", admin.site.urls),
    path("", check),

    path("api/picture/<str:rq_id>", PictureAPI.as_view()),
    path("api/emoji/<str:rq_id>", EmojiAPI.as_view()),

    path("stable/<str:rq_id>/<str:paint>", stable),
    path("style/<str:rq_id>", style),

    path("showImg/<str:rq_id>/<str:t_name>", show_img),
    path("showEmoji/<str:rq_id>/<str:t_name>/<str:e_name>/<str:s_num>", show_emoji),

    path("test/", test_reqeust),
]
