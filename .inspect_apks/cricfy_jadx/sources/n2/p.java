package n2;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements r2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f8723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8724c;

    public p(String str, List list, boolean z10) {
        this.f8722a = str;
        this.f8723b = Collections.unmodifiableList(list);
        this.f8724c = z10;
    }
}
