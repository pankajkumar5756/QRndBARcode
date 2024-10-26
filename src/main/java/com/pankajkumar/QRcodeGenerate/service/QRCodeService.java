package com.pankajkumar.QRcodeGenerate.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.pankajkumar.QRcodeGenerate.model.PersonalDataModel;

@Service
public class QRCodeService {

	public byte[] generateQrCode(String Text) throws WriterException, IOException {
		MultiFormatWriter barcodeWriter = new MultiFormatWriter();
		BitMatrix bitMatrix = barcodeWriter.encode(Text, BarcodeFormat.QR_CODE, 200, 200); // this is for QRcode
//		BitMatrix bitMatrix = barcodeWriter.encode(Text, BarcodeFormat.CODE_128, 175, 175);  // this for bar code
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArray);
		return byteArray.toByteArray();

	}

	// generate code from object(model)
	
	public byte[] generateQRCodeByObject(PersonalDataModel model) throws IOException, WriterException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(model);
		MultiFormatWriter multi = new MultiFormatWriter();
		BitMatrix bitMatrix = multi.encode(jsonString, BarcodeFormat.QR_CODE, 175, 175);
		ByteArrayOutputStream bytArray = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", bytArray);
		return bytArray.toByteArray();
	}

}
