package ua;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements ta.l, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12399v;

    public u0() {
        q.d(2, "expectedValuesPerKey");
        this.f12399v = 2;
    }

    @Override // ta.l
    public final Object get() {
        return new ArrayList(this.f12399v);
    }
}
