package `in`.crakcode.javadesignpatterns.factory.complete.factory



// Base Fragment
interface BaseTestFragment  {
    abstract fun display()
}


// Concrete Fragments
class HomeFragment : BaseTestFragment {
    override fun display() {
        print("Home")
    }
}


class SettingsFragment : BaseTestFragment {
    override fun display() {
        print("Home")
    }
}


// FragmentFactory
object FragmentFactory {
    fun getFragment(fragmentType: String?): BaseTestFragment? {
        if ("Home".equals(fragmentType, ignoreCase = true)) {
            return HomeFragment()
        } else if ("Settings".equals(fragmentType, ignoreCase = true)) {
            return SettingsFragment()
        }
        return null
    }
}


fun main() {
    val fragment = FragmentFactory.getFragment("Home")
    fragment?.display()
}

