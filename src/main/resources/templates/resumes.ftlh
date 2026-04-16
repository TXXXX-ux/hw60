<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Список резюме</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <#include "navbar.ftlh">
        <div class="container mt-4">
            <h2 class="mb-4 text-center">База резюме</h2>
            <div class="row">
                <#if resumes?? && resumes?size gt 0>
                    <#list resumes as resume>
                        <div class="col-md-12 mb-3">
                            <div class="card shadow-sm border-start border-info border-4">
                                <div class="card-body d-flex justify-content-between align-items-center">
                                    <div>
                                        <h5 class="mb-1">${resume.title}</h5>
                                        <p class="text-muted mb-0">${resume.info!"Детали не указаны"}</p>
                                    </div>
                                        <a href="/resumes${resume.id}" class="btn btn-outline-info">Посмотреть</a>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="col-12 text-center">
                        <p class="text-muted">Резюме пока не добавлены.</p>
                    </div>
                </#if>
            </div>
        </div>
    </body>
</html>