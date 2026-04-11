package i6;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f6393b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f6394a;

    public e0(r rVar) {
        this.f6394a = rVar;
    }

    @Override // i6.r
    public final q a(Object obj, int i, int i10, c6.i iVar) {
        return this.f6394a.a(new h(((Uri) obj).toString()), i, i10, iVar);
    }

    @Override // i6.r
    public final boolean b(Object obj) {
        return f6393b.contains(((Uri) obj).getScheme());
    }
}
