<#import "layout.ftlh" as main>
<@main.layout>
    <h2 class="mb-4 text-center">Актуальные вакансии</h2>
    <div class="row">
        <#if vacancies?? && vacancies?size gt 0>
            <#list vacancies as vacancy>
                <div class="col-md-6 col-lg-4 mb-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title text-primary">${vacancy.title}</h5>
                            <p class="card-text">${vacancy.description!""}</p>
                            <p class="fw-bold text-success">${vacancy.salary!0} сом</p>
                        </div>
                        <div class="card-footer bg-transparent border-top-0 pb-3">
                            <a href="/vacancies${vacancy.id}" class="btn btn-primary w-100">Откликнуться</a>
                        </div>
                    </div>
                </div>
            </#list>
        <#else>
            <p class="text-center text-muted">Вакансий пока нет.</p>
        </#if>
    </div>
</@main.layout>