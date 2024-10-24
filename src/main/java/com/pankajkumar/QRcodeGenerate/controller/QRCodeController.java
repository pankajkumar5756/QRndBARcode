package com.pankajkumar.QRcodeGenerate.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.pankajkumar.QRcodeGenerate.service.QRCodeService;

@RestController
public class QRCodeController {

	@Autowired
	private QRCodeService qrService;

	@PostMapping("/generateqrcode")
	public ResponseEntity<?> generateQRCodeText(@RequestParam("text") String text) throws WriterException, IOException {

		byte[] barcodeImage = qrService.generateQrCode(text);
		return ResponseEntity.ok().header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "inline; filename=barcode.png")
				.contentType(MediaType.IMAGE_PNG).body(barcodeImage);

	}

}
