package d1;

import java.io.FileInputStream;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends xd.c {
    public FileLock A;
    public boolean B;
    public /* synthetic */ Object C;
    public final /* synthetic */ z0 D;
    public int E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public xe.c f3320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FileInputStream f3321z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(z0 z0Var, xd.c cVar) {
        super(cVar);
        this.D = z0Var;
    }

    @Override // xd.a
    public final Object o(Object obj) {
        this.C = obj;
        this.E |= Integer.MIN_VALUE;
        return this.D.c(null, this);
    }
}
