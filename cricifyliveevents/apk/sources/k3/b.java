package k3;

import a3.k0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import v1.l0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends u8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f6902e;

    public static l3.a T(t tVar) {
        String strS = tVar.s();
        strS.getClass();
        String strS2 = tVar.s();
        strS2.getClass();
        return new l3.a(strS, strS2, tVar.r(), tVar.r(), Arrays.copyOfRange(tVar.f14609a, tVar.f14610b, tVar.f14611c));
    }

    @Override // u8.a
    public final l0 p(j3.a aVar, ByteBuffer byteBuffer) {
        switch (this.f6902e) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (byteBuffer.get() != 116) {
                    return null;
                }
                k0 k0Var = new k0(byteBuffer.limit(), byteBuffer.array());
                int i = 12;
                k0Var.t(12);
                int iF = (k0Var.f() + k0Var.i(12)) - 4;
                k0Var.t(44);
                k0Var.u(k0Var.i(12));
                k0Var.t(16);
                ArrayList arrayList = new ArrayList();
                while (k0Var.f() < iF) {
                    k0Var.t(48);
                    int i10 = k0Var.i(8);
                    k0Var.t(4);
                    int iF2 = k0Var.f() + k0Var.i(i);
                    String str = null;
                    String str2 = null;
                    while (k0Var.f() < iF2) {
                        int i11 = k0Var.i(8);
                        int i12 = k0Var.i(8);
                        int iF3 = k0Var.f() + i12;
                        if (i11 == 2) {
                            int i13 = k0Var.i(16);
                            k0Var.t(8);
                            if (i13 == 3) {
                                while (k0Var.f() < iF3) {
                                    int i14 = k0Var.i(8);
                                    Charset charset = StandardCharsets.US_ASCII;
                                    byte[] bArr = new byte[i14];
                                    k0Var.l(i14, bArr);
                                    String str3 = new String(bArr, charset);
                                    int i15 = k0Var.i(8);
                                    for (int i16 = 0; i16 < i15; i16++) {
                                        k0Var.u(k0Var.i(8));
                                    }
                                    str = str3;
                                }
                            }
                        } else if (i11 == 21) {
                            Charset charset2 = StandardCharsets.US_ASCII;
                            byte[] bArr2 = new byte[i12];
                            k0Var.l(i12, bArr2);
                            str2 = new String(bArr2, charset2);
                        }
                        k0Var.q(iF3 * 8);
                    }
                    k0Var.q(iF2 * 8);
                    if (str != null && str2 != null) {
                        arrayList.add(new a(i10, str.concat(str2)));
                    }
                    i = 12;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new l0(arrayList);
            default:
                return new l0(T(new t(byteBuffer.limit(), byteBuffer.array())));
        }
    }
}
