package l6;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements c6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f7978a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f7979b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int e(k kVar, f6.f fVar) {
        try {
            int iV = kVar.v();
            if ((iV & 65496) == 65496 || iV == 19789 || iV == 18761) {
                int iG = g(kVar);
                if (iG != -1) {
                    byte[] bArr = (byte[]) fVar.d(iG, byte[].class);
                    try {
                        return h(kVar, bArr, iG);
                    } finally {
                        fVar.h(bArr);
                    }
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    return -1;
                }
            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iV);
                return -1;
            }
        } catch (j unused) {
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType f(k kVar) {
        try {
            int iV = kVar.v();
            if (iV == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int iL = (iV << 8) | kVar.l();
            if (iL == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int iL2 = (iL << 8) | kVar.l();
            if (iL2 == -1991225785) {
                kVar.skip(21L);
                try {
                    return kVar.l() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (j unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (iL2 == 1380533830) {
                kVar.skip(4L);
                if (((kVar.v() << 16) | kVar.v()) != 1464156752) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int iV2 = (kVar.v() << 16) | kVar.v();
                if ((iV2 & (-256)) != 1448097792) {
                    return ImageHeaderParser$ImageType.UNKNOWN;
                }
                int i = iV2 & 255;
                if (i == 88) {
                    kVar.skip(4L);
                    short sL = kVar.l();
                    return (sL & 2) != 0 ? ImageHeaderParser$ImageType.ANIMATED_WEBP : (sL & 16) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                if (i != 76) {
                    return ImageHeaderParser$ImageType.WEBP;
                }
                kVar.skip(4L);
                return (kVar.l() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
            }
            if (((kVar.v() << 16) | kVar.v()) != 1718909296) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int iV3 = (kVar.v() << 16) | kVar.v();
            if (iV3 == 1635150195) {
                return ImageHeaderParser$ImageType.ANIMATED_AVIF;
            }
            int i10 = 0;
            boolean z2 = iV3 == 1635150182;
            kVar.skip(4L);
            int i11 = iL2 - 16;
            if (i11 % 4 == 0) {
                while (i10 < 5 && i11 > 0) {
                    int iV4 = (kVar.v() << 16) | kVar.v();
                    if (iV4 == 1635150195) {
                        return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                    }
                    if (iV4 == 1635150182) {
                        z2 = true;
                    }
                    i10++;
                    i11 -= 4;
                }
            }
            return z2 ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
        } catch (j unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(l6.k r9) {
        /*
        L0:
            short r0 = r9.l()
            r1 = 255(0xff, float:3.57E-43)
            r2 = 3
            r3 = -1
            java.lang.String r4 = "DfltImageHeaderParser"
            if (r0 == r1) goto L24
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown segmentId="
            r9.<init>(r1)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
            return r3
        L24:
            short r0 = r9.l()
            r1 = 218(0xda, float:3.05E-43)
            if (r0 != r1) goto L2d
            goto L6a
        L2d:
            r1 = 217(0xd9, float:3.04E-43)
            if (r0 != r1) goto L3d
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = "Found MARKER_EOI in exif segment"
            android.util.Log.d(r4, r9)
            return r3
        L3d:
            int r1 = r9.v()
            int r1 = r1 + (-2)
            r5 = 225(0xe1, float:3.15E-43)
            if (r0 == r5) goto L6b
            long r5 = (long) r1
            long r7 = r9.skip(r5)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 == 0) goto L0
            boolean r9 = android.util.Log.isLoggable(r4, r2)
            if (r9 == 0) goto L6a
            java.lang.String r9 = ", wanted to skip: "
            java.lang.String r2 = ", but actually skipped: "
            java.lang.String r5 = "Unable to skip enough data, type: "
            java.lang.StringBuilder r9 = l4.a.p(r0, r1, r5, r9, r2)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L6a:
            return r3
        L6b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.l.g(l6.k):int");
    }

    public static int h(k kVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        short s3;
        int iZ = kVar.z(i, bArr);
        short s10 = -1;
        if (iZ == i) {
            int i10 = 0;
            byte[] bArr2 = f7978a;
            boolean z2 = bArr != null && i > bArr2.length;
            if (z2) {
                int i11 = 0;
                while (true) {
                    if (i11 >= bArr2.length) {
                        break;
                    }
                    if (bArr[i11] != bArr2[i11]) {
                        z2 = false;
                        break;
                    }
                    i11++;
                }
            }
            if (!z2) {
                if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                    return -1;
                }
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
            short s11 = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
            if (s11 != 18761) {
                if (s11 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) s11));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            byteBuffer.order(byteOrder);
            int i12 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
            int i13 = i12 + 6;
            short s12 = byteBuffer.remaining() - i13 >= 2 ? byteBuffer.getShort(i13) : (short) -1;
            while (i10 < s12) {
                int i14 = (i10 * 12) + i12 + 8;
                short s13 = byteBuffer.remaining() - i14 >= 2 ? byteBuffer.getShort(i14) : s10;
                if (s13 != 274) {
                    s3 = s10;
                } else {
                    int i15 = i14 + 2;
                    short s14 = byteBuffer.remaining() - i15 >= 2 ? byteBuffer.getShort(i15) : s10;
                    if (s14 < 1 || s14 > 12) {
                        s3 = s10;
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) s14));
                        }
                    } else {
                        int i16 = i14 + 4;
                        int i17 = byteBuffer.remaining() - i16 >= 4 ? byteBuffer.getInt(i16) : s10;
                        if (i17 < 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                            s3 = s10;
                        } else {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                s3 = s10;
                                StringBuilder sbP = l4.a.p(i10, s13, "Got tagIndex=", " tagType=", " formatCode=");
                                sbP.append((int) s14);
                                sbP.append(" componentCount=");
                                sbP.append(i17);
                                Log.d("DfltImageHeaderParser", sbP.toString());
                            } else {
                                s3 = s10;
                            }
                            int i18 = i17 + f7979b[s14];
                            if (i18 <= 4) {
                                int i19 = i14 + 8;
                                if (i19 < 0 || i19 > byteBuffer.remaining()) {
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i19 + " tagType=" + ((int) s13));
                                    }
                                } else {
                                    if (i18 >= 0 && i18 + i19 <= byteBuffer.remaining()) {
                                        return byteBuffer.remaining() - i19 >= 2 ? byteBuffer.getShort(i19) : s3;
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) s13));
                                    }
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) s14));
                            }
                        }
                    }
                }
                i10++;
                s10 = s3;
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iZ);
            return -1;
        }
        return s10;
    }

    @Override // c6.e
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        x6.f.c(byteBuffer, "Argument must not be null");
        return f(new wb.c(byteBuffer));
    }

    @Override // c6.e
    public final int b(ByteBuffer byteBuffer, f6.f fVar) {
        wb.c cVar = new wb.c(byteBuffer);
        x6.f.c(fVar, "Argument must not be null");
        return e(cVar, fVar);
    }

    @Override // c6.e
    public final int c(InputStream inputStream, f6.f fVar) {
        rc.b bVar = new rc.b(21, inputStream);
        x6.f.c(fVar, "Argument must not be null");
        return e(bVar, fVar);
    }

    @Override // c6.e
    public final ImageHeaderParser$ImageType d(InputStream inputStream) {
        return f(new rc.b(21, inputStream));
    }
}
