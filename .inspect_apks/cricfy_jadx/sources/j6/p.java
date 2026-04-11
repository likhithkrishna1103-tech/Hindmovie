package j6;

import android.graphics.PointF;
import g6.i0;
import ka.v;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends w {
    public final /* synthetic */ l6.b A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ v f6661y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ w f6662z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(v vVar, w wVar, l6.b bVar) {
        super(21);
        this.f6661y = vVar;
        this.f6662z = wVar;
        this.A = bVar;
    }

    @Override // nb.w
    public final Object F(v vVar) {
        float f = vVar.f7378a;
        float f10 = vVar.f7379b;
        String str = ((l6.b) vVar.f).f7837a;
        String str2 = ((l6.b) vVar.f7383g).f7837a;
        float f11 = vVar.f7380c;
        float f12 = vVar.f7381d;
        float f13 = vVar.f7382e;
        v vVar2 = this.f6661y;
        vVar2.f7378a = f;
        vVar2.f7379b = f10;
        vVar2.f = str;
        vVar2.f7383g = str2;
        vVar2.f7380c = f11;
        vVar2.f7381d = f12;
        vVar2.f7382e = f13;
        String str3 = (String) ((i0) this.f6662z.f9017x);
        l6.b bVar = (l6.b) (vVar.f7381d == 1.0f ? vVar.f7383g : vVar.f);
        String str4 = bVar.f7838b;
        float f14 = bVar.f7839c;
        int i = bVar.f7840d;
        int i10 = bVar.f7841e;
        float f15 = bVar.f;
        float f16 = bVar.f7842g;
        int i11 = bVar.f7843h;
        int i12 = bVar.i;
        float f17 = bVar.f7844j;
        boolean z10 = bVar.f7845k;
        PointF pointF = bVar.f7846l;
        PointF pointF2 = bVar.f7847m;
        l6.b bVar2 = this.A;
        bVar2.f7837a = str3;
        bVar2.f7838b = str4;
        bVar2.f7839c = f14;
        bVar2.f7840d = i;
        bVar2.f7841e = i10;
        bVar2.f = f15;
        bVar2.f7842g = f16;
        bVar2.f7843h = i11;
        bVar2.i = i12;
        bVar2.f7844j = f17;
        bVar2.f7845k = z10;
        bVar2.f7846l = pointF;
        bVar2.f7847m = pointF2;
        return bVar2;
    }
}
