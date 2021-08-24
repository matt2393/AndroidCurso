package com.matdev.appcurso

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.matdev.appcurso.databinding.DialogAddConfirmBinding
import com.matdev.appcurso.model.entities.Meal

class ConfirmAddDialog: DialogFragment() {

    companion object {
        private const val MEAL = "MEAL"
        fun newInstance(meal: Meal) = ConfirmAddDialog().apply {
            arguments = Bundle().apply {
                putParcelable(MEAL, meal)
            }
        }
    }
    private var meal: Meal? = null
    private var binding: DialogAddConfirmBinding? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alert = AlertDialog.Builder(requireContext())
        binding = DialogAddConfirmBinding.inflate(requireActivity().layoutInflater, null, false)

        arguments?.let {
            meal = it.getParcelable(MEAL)
        }
        val tit = "¿Desea añadir ${meal?.strMeal}?"
        binding?.textTitleDialog?.text = tit
        val desc = "El producto ${meal?.strMeal} se añadira a su carritos de compras"
        binding?.textDescDialog?.text = desc
        binding?.buttonCancelar?.setOnClickListener {
            dismiss()
        }
        binding?.buttonAceptar?.setOnClickListener {
            if(meal!=null) {
                var datos = getCart(requireContext())
                if(datos==null) {
                    datos = arrayListOf()
                }
                datos.add(meal!!)
                saveCart(requireContext(), datos)
            }
            dismiss()
        }


        alert.setView(binding?.root)
        return alert.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}