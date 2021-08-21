package dev.mattdev.claseandroidmenu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import dev.mattdev.claseandroidmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        val frInit = MainFragment.newInstance("Inicio", "Este es el fragment Inicio")
        val frData = MainFragment.newInstance("Datos", "Este es el fragment Datos")
        val frCuenta = MainFragment.newInstance("Cuenta", "Este es el fragment Cuenta")


        val frIniDrawer = MainFragment.newInstance("InicioDrawer", "Este es el fragment InicioDrawer")
        val frCueDrawer = MainFragment.newInstance("CuentaDrawer", "Este es el fragment Cuenta Drawer")

        changeFrag(frInit, MainFragment.TAG)
        binding.bottomMain.setOnItemSelectedListener {
            val fr = when(it.itemId) {
                R.id.inicioHome -> frInit
                R.id.datosHome -> frData
                R.id.cuentaHome -> frCuenta
                else -> frInit
            }
            changeFrag(fr, MainFragment.TAG)
            true
        }

        val toogle = ActionBarDrawerToggle(
            this,
            binding.drawerMain, binding.toolbarMain, R.string.abrir_menu, R.string.cerrar_menu)
        binding.drawerMain.addDrawerListener(toogle)
        toogle.syncState()
        binding.drawerMain.setScrimColor(Color.TRANSPARENT)
        binding.navMain.setNavigationItemSelectedListener {
            binding.drawerMain.closeDrawer(GravityCompat.START)
            val fr = when(it.itemId) {
                R.id.drawerInicio-> frIniDrawer
                R.id.drawerCuenta-> frCueDrawer
                else -> frIniDrawer
            }
            changeFrag(fr, MainFragment.TAG)
            true

        }

    }
    private fun changeFrag(fr: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerMain, fr, tag)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.homeMain -> showToast("Home")
            R.id.perfilMain -> showToast("Perfil")
            R.id.configMain -> showToast("Config")
        }
        return super.onOptionsItemSelected(item)
    }
    private fun showToast(mess: String) {
        Toast.makeText(this, mess, Toast.LENGTH_SHORT).show()
    }
}