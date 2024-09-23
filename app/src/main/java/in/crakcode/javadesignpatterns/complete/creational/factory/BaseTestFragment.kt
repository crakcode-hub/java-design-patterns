package `in`.crakcode.javadesignpatterns.complete.creational.factory



// Base Fragment
interface BaseTestFragment  {
    abstract fun display()
}


// Concrete Fragments
class HomeFragment(val url: String) : BaseTestFragment {
    override fun display() {
        print("Home")
    }
}


class SettingsFragment : BaseTestFragment {
    override fun display() {
        print("Home")
    }
}

class TestFragment : BaseTestFragment {
    override fun display() {
        print("Test fragment")
    }

}

class Test1Fragment : BaseTestFragment {
    override fun display() {
        print("Test fragment")
    }

}


// FragmentFactory
object FragmentFactory {
    fun getFragment(fragmentType: String?): BaseTestFragment? {
        if ("Home".equals(fragmentType, ignoreCase = true)) {
            return HomeFragment("")
        } else if ("Settings".equals(fragmentType, ignoreCase = true)) {
            return SettingsFragment()
        } else if ("Test".equals(fragmentType, ignoreCase = true)) {
            return TestFragment()
        } else if ("Test1".equals(fragmentType, ignoreCase = true)) {
            return Test1Fragment()
        }
        return null
    }
}


class Abc {
    fun makeFragmentCall(baseTestFragment: BaseTestFragment){
        baseTestFragment.display()
    }


}


fun main() {
    val fragment = FragmentFactory.getFragment("Home")
    fragment?.display()
}

