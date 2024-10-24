package com.pankajkumar.QRcodeGenerate.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

@Service
public class QRCodeService {

	public byte[] generateQrCode(String Text) throws WriterException, IOException {
		MultiFormatWriter barcodeWriter = new MultiFormatWriter();
		BitMatrix bitMatrix = barcodeWriter.encode(Text, BarcodeFormat.QR_CODE, 175, 175);
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArray);
		return byteArray.toByteArray();

	}

}
