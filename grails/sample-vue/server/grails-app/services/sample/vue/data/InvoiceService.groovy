package sample.vue.data

import grails.gorm.services.Service

@Service(Invoice)
interface InvoiceService {

    Invoice get(Serializable id)

    List<Invoice> list(Map args)

    Long count()

    Invoice delete(Serializable id)

    Invoice save(Invoice invoice)
}
