package d1;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends xd.c {
    public /* synthetic */ Object A;
    public int B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Serializable f3226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Iterator f3227z;

    @Override // xd.a
    public final Object o(Object obj) {
        this.A = obj;
        this.B |= Integer.MIN_VALUE;
        return a.a.b(null, null, this);
    }
}
