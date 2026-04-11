package d7;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f3485b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f3486a;

    public h0(t tVar) {
        this.f3486a = tVar;
    }

    @Override // d7.t
    public final s a(Object obj, int i, int i10, x6.h hVar) {
        return this.f3486a.a(new j(((Uri) obj).toString()), i, i10, hVar);
    }

    @Override // d7.t
    public final boolean b(Object obj) {
        return f3485b.contains(((Uri) obj).getScheme());
    }
}
