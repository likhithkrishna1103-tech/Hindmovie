package h2;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements l2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5749c;

    public p(String str, List list, boolean z2) {
        this.f5747a = str;
        this.f5748b = Collections.unmodifiableList(list);
        this.f5749c = z2;
    }
}
