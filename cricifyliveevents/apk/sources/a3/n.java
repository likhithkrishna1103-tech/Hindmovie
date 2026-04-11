package a3;

import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public z0 f221v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f224y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f220z = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    public static final l4.c0 A = new l4.c0(new m(0));
    public static final l4.c0 B = new l4.c0(new m(1));

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public x3.e f223x = new x3.e();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f222w = true;

    public final void a(int i, ArrayList arrayList) {
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                arrayList.add(new h4.a());
                break;
            case 1:
                arrayList.add(new h4.c());
                break;
            case 2:
                arrayList.add(new h4.d(0));
                break;
            case 3:
                arrayList.add(new b3.a());
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                p pVarM = A.M(0);
                if (pVarM == null) {
                    arrayList.add(new f3.c());
                } else {
                    arrayList.add(pVarM);
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                arrayList.add(new g3.b());
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                arrayList.add(new s3.d(this.f223x, this.f222w ? 0 : 2));
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                arrayList.add(new t3.d(0));
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                x3.e eVar = this.f223x;
                int i10 = this.f222w ? 0 : 32;
                ua.g0 g0Var = ua.i0.f12341w;
                arrayList.add(new u3.j(eVar, i10, null, z0.f12413z, null));
                arrayList.add(new u3.m(this.f223x, this.f222w ? 0 : 16));
                break;
            case 9:
                arrayList.add(new v3.d());
                break;
            case 10:
                arrayList.add(new h4.a0());
                break;
            case 11:
                if (this.f221v == null) {
                    ua.g0 g0Var2 = ua.i0.f12341w;
                    this.f221v = z0.f12413z;
                }
                arrayList.add(new h4.e0(1, !this.f222w ? 1 : 0, this.f223x, new y1.y(0L), new h4.f(0, this.f221v)));
                break;
            case 12:
                i4.d dVar = new i4.d();
                dVar.f6202c = 0;
                dVar.f6203d = -1L;
                dVar.f = -1;
                dVar.f6205g = -1L;
                arrayList.add(dVar);
                break;
            case 14:
                arrayList.add(new i3.a(this.f224y));
                break;
            case 15:
                p pVarM2 = B.M(new Object[0]);
                if (pVarM2 != null) {
                    arrayList.add(pVarM2);
                }
                break;
            case 16:
                arrayList.add(new c3.b(!this.f222w ? 1 : 0, this.f223x));
                break;
            case 17:
                arrayList.add(new e3.a(1));
                break;
            case 18:
                arrayList.add(new d3.a(2));
                break;
            case 19:
                arrayList.add(new e3.a(0));
                break;
            case 20:
                arrayList.add(new d3.a(1));
                break;
            case 21:
                arrayList.add(new d3.a(0));
                break;
        }
    }

    @Override // a3.s
    public final synchronized p[] h(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = f220z;
            arrayList = new ArrayList(21);
            List list = (List) map.get("Content-Type");
            int iV = n5.a.v((list == null || list.isEmpty()) ? null : (String) list.get(0));
            if (iV != -1) {
                a(iV, arrayList);
            }
            int iW = n5.a.w(uri);
            if (iW != -1 && iW != iV) {
                a(iW, arrayList);
            }
            for (int i = 0; i < 21; i++) {
                int i10 = iArr[i];
                if (i10 != iV && i10 != iW) {
                    a(i10, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (p[]) arrayList.toArray(new p[0]);
    }
}
