package aa;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements z9.l, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f758u;

    public w0() {
        q.c("expectedValuesPerKey", 2);
        this.f758u = 2;
    }

    @Override // z9.l
    public final Object get() {
        return new ArrayList(this.f758u);
    }
}
