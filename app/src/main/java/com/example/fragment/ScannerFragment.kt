package com.example.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.FragmentScannerBinding
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult

class ScannerFragment : Fragment(R.layout.fragment_scanner) {

    private var _binding: FragmentScannerBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentScannerBinding.bind(view)

        // Continuous scanning only (camera on)
        binding.barcodeScanner.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                // Nothing to do for now
            }

            override fun possibleResultPoints(resultPoints: MutableList<com.google.zxing.ResultPoint>?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        binding.barcodeScanner.resume() // Camera start
    }

    override fun onPause() {
        super.onPause()
        binding.barcodeScanner.pause() // Camera stop
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}