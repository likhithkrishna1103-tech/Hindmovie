package w2;

import aa.c1;
import aa.j0;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements r {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c1 f13658u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f13656y = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final pb.c f13657z = new pb.c(new r2.h(13));
    public static final pb.c A = new pb.c(new r2.h(14));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public k8.b0 f13660w = new k8.b0(27);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13659v = true;

    public final void a(int i, ArrayList arrayList) {
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                arrayList.add(new d4.a());
                break;
            case 1:
                arrayList.add(new d4.c());
                break;
            case 2:
                arrayList.add(new d4.d(0));
                break;
            case 3:
                arrayList.add(new x2.a());
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                o oVarF = f13657z.f(0);
                if (oVarF == null) {
                    arrayList.add(new b3.b());
                } else {
                    arrayList.add(oVarF);
                }
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                arrayList.add(new c3.b());
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                arrayList.add(new o3.d(this.f13660w, this.f13659v ? 0 : 2));
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                arrayList.add(new p3.d(0));
                break;
            case 8:
                k8.b0 b0Var = this.f13660w;
                int i10 = this.f13659v ? 0 : 32;
                aa.h0 h0Var = j0.f690v;
                arrayList.add(new q3.k(b0Var, i10, null, null, c1.f650y, null));
                arrayList.add(new q3.n(this.f13660w, this.f13659v ? 0 : 16));
                break;
            case 9:
                arrayList.add(new r3.d());
                break;
            case 10:
                arrayList.add(new d4.a0());
                break;
            case 11:
                if (this.f13658u == null) {
                    aa.h0 h0Var2 = j0.f690v;
                    this.f13658u = c1.f650y;
                }
                arrayList.add(new d4.f0(1, !this.f13659v ? 1 : 0, this.f13660w, new s1.z(0L), new d4.f(0, this.f13658u)));
                break;
            case 12:
                e4.d dVar = new e4.d();
                dVar.f4410c = 0;
                dVar.f4411d = -1L;
                dVar.f = -1;
                dVar.f4413g = -1L;
                arrayList.add(dVar);
                break;
            case 14:
                arrayList.add(new e3.a(this.f13661x));
                break;
            case 15:
                o oVarF2 = A.f(new Object[0]);
                if (oVarF2 != null) {
                    arrayList.add(oVarF2);
                }
                break;
            case 16:
                arrayList.add(new y2.b(!this.f13659v ? 1 : 0, this.f13660w));
                break;
            case 17:
                arrayList.add(new a3.a(1));
                break;
            case 18:
                arrayList.add(new d3.a(1));
                break;
            case 19:
                arrayList.add(new a3.a(0));
                break;
            case 20:
                arrayList.add(new d3.a(0));
                break;
            case 21:
                arrayList.add(new d3.a(2));
                break;
        }
    }

    @Override // w2.r
    public final synchronized o[] j(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            int[] iArr = f13656y;
            arrayList = new ArrayList(21);
            List list = (List) map.get("Content-Type");
            int iL = com.bumptech.glide.c.l((list == null || list.isEmpty()) ? null : (String) list.get(0));
            if (iL != -1) {
                a(iL, arrayList);
            }
            int iM = com.bumptech.glide.c.m(uri);
            if (iM != -1 && iM != iL) {
                a(iM, arrayList);
            }
            for (int i = 0; i < 21; i++) {
                int i10 = iArr[i];
                if (i10 != iL && i10 != iM) {
                    a(i10, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (o[]) arrayList.toArray(new o[0]);
    }
}
