package s2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements y1.h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ f3.a f11200v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ t f11201w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ y f11202x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ IOException f11203y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ boolean f11204z;

    public /* synthetic */ g0(f3.a aVar, t tVar, y yVar, IOException iOException, boolean z10) {
        this.f11200v = aVar;
        this.f11201w = tVar;
        this.f11202x = yVar;
        this.f11203y = iOException;
        this.f11204z = z10;
    }

    @Override // y1.h
    public final void accept(Object obj) {
        i0 i0Var = (i0) obj;
        f3.a aVar = this.f11200v;
        i0Var.f(aVar.f3935w, (c0) aVar.f3936x, this.f11201w, this.f11202x, this.f11203y, this.f11204z);
    }
}
