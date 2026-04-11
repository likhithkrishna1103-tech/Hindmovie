package g3;

import androidx.media3.decoder.DecoderInputBuffer;
import com.bumptech.glide.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import p1.l0;
import s1.t;
import s1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4947d;

    public static h3.a y(u uVar) {
        String strS = uVar.s();
        strS.getClass();
        String strS2 = uVar.s();
        strS2.getClass();
        return new h3.a(strS, strS2, uVar.r(), uVar.r(), Arrays.copyOfRange(uVar.f11709a, uVar.f11710b, uVar.f11711c));
    }

    @Override // com.bumptech.glide.c
    public final l0 i(f3.a aVar, ByteBuffer byteBuffer) {
        switch (this.f4947d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (byteBuffer.get() != 116) {
                    return null;
                }
                t tVar = new t(byteBuffer.limit(), byteBuffer.array());
                int i = 12;
                tVar.t(12);
                int iF = (tVar.f() + tVar.i(12)) - 4;
                tVar.t(44);
                tVar.u(tVar.i(12));
                tVar.t(16);
                ArrayList arrayList = new ArrayList();
                while (tVar.f() < iF) {
                    tVar.t(48);
                    int i10 = tVar.i(8);
                    tVar.t(4);
                    int iF2 = tVar.f() + tVar.i(i);
                    String str = null;
                    String str2 = null;
                    while (tVar.f() < iF2) {
                        int i11 = tVar.i(8);
                        int i12 = tVar.i(8);
                        int iF3 = tVar.f() + i12;
                        if (i11 == 2) {
                            int i13 = tVar.i(16);
                            tVar.t(8);
                            if (i13 == 3) {
                                while (tVar.f() < iF3) {
                                    int i14 = tVar.i(8);
                                    Charset charset = StandardCharsets.US_ASCII;
                                    byte[] bArr = new byte[i14];
                                    tVar.l(i14, bArr);
                                    String str3 = new String(bArr, charset);
                                    int i15 = tVar.i(8);
                                    for (int i16 = 0; i16 < i15; i16++) {
                                        tVar.u(tVar.i(8));
                                    }
                                    str = str3;
                                }
                            }
                        } else if (i11 == 21) {
                            Charset charset2 = StandardCharsets.US_ASCII;
                            byte[] bArr2 = new byte[i12];
                            tVar.l(i12, bArr2);
                            str2 = new String(bArr2, charset2);
                        }
                        tVar.q(iF3 * 8);
                    }
                    tVar.q(iF2 * 8);
                    if (str != null && str2 != null) {
                        arrayList.add(new a(str.concat(str2), i10));
                    }
                    i = 12;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new l0(arrayList);
            default:
                return new l0(y(new u(byteBuffer.limit(), byteBuffer.array())));
        }
    }
}
