package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f4292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f4294e;
    public final List f;

    public a(long j5, int i, ArrayList arrayList, List list, List list2, List list3) {
        this.f4290a = j5;
        this.f4291b = i;
        this.f4292c = Collections.unmodifiableList(arrayList);
        this.f4293d = Collections.unmodifiableList(list);
        this.f4294e = Collections.unmodifiableList(list2);
        this.f = Collections.unmodifiableList(list3);
    }
}
