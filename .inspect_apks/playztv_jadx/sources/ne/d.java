package ne;

import h4.z;

/* JADX INFO: loaded from: classes.dex */
public final class d extends td.c {
    public z A;
    public c B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public /* synthetic */ Object f8996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8997y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ z f8998z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(z zVar, td.c cVar) {
        super(cVar);
        this.f8998z = zVar;
    }

    @Override // td.a
    public final Object o(Object obj) {
        this.f8996x = obj;
        this.f8997y |= Integer.MIN_VALUE;
        return this.f8998z.o(null, this);
    }
}
