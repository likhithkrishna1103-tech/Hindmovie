package wc;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends xd.c {
    public d A;
    public xe.c B;
    public Map C;
    public Object D;
    public /* synthetic */ Object E;
    public final /* synthetic */ c F;
    public int G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Map f14135y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Iterator f14136z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, xd.c cVar2) {
        super(cVar2);
        this.F = cVar;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.E = obj;
        this.G |= Integer.MIN_VALUE;
        return this.F.b(this);
    }
}
