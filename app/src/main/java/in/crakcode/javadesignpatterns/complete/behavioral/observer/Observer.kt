package `in`.crakcode.javadesignpatterns.complete.behavioral.observer


interface Subscriber {
    fun setData(value : String)
}




class SubscriberImp : Subscriber {

    override fun setData(value: String) {
        println("subscriber1 $value")
    }

}

class Subscriber2Imp : Subscriber {

    override fun setData(value: String) {
        println("subscriber2 $value")
    }

}


class Observer {

    val list : MutableList<Subscriber> = mutableListOf()

    fun setSubscriber(subscriber: Subscriber){
        list.add(subscriber)
    }


    fun update(value: String){
        for(li in list){
            li.setData(value)
        }
    }

}


fun main() {

    val subscriber1 : Subscriber = SubscriberImp()
    val subscriber2 : Subscriber = Subscriber2Imp()

    val observer = Observer()
    observer.setSubscriber(subscriber1)
    observer.setSubscriber(subscriber2)
    observer.update("test")

}

