package k2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f6824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f6825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6826e;
    public final List f;

    public a(long j4, int i, ArrayList arrayList, List list, List list2, List list3) {
        this.f6822a = j4;
        this.f6823b = i;
        this.f6824c = Collections.unmodifiableList(arrayList);
        this.f6825d = Collections.unmodifiableList(list);
        this.f6826e = Collections.unmodifiableList(list2);
        this.f = Collections.unmodifiableList(list3);
    }
}
