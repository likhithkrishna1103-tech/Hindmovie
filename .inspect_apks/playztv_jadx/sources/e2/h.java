package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4331d;

    public h(String str, long j5, ArrayList arrayList, List list) {
        this.f4328a = str;
        this.f4329b = j5;
        this.f4330c = Collections.unmodifiableList(arrayList);
        this.f4331d = Collections.unmodifiableList(list);
    }
}
