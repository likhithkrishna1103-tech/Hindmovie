package k2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f6861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f6862d;

    public h(String str, long j4, ArrayList arrayList, List list) {
        this.f6859a = str;
        this.f6860b = j4;
        this.f6861c = Collections.unmodifiableList(arrayList);
        this.f6862d = Collections.unmodifiableList(list);
    }
}
