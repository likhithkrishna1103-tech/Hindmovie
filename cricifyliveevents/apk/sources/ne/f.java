package ne;

import java.util.Iterator;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends sd.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ l7.a f9144v;

    public f(l7.a aVar) {
        this.f9144v = aVar;
    }

    @Override // sd.a
    public final int a() {
        return ((Matcher) this.f9144v.f7866w).groupCount() + 1;
    }

    public final d b(int i) {
        Matcher matcher = (Matcher) this.f9144v.f7866w;
        ke.c cVarI = com.bumptech.glide.f.I(matcher.start(i), matcher.end(i));
        if (cVarI.f7418v < 0) {
            return null;
        }
        String strGroup = matcher.group(i);
        ge.i.d(strGroup, "group(...)");
        return new d(strGroup, cVarI);
    }

    @Override // sd.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof d) {
            return super.contains((d) obj);
        }
        return false;
    }

    @Override // sd.a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new me.j(new me.d(new me.h(2, new ke.c(0, size() - 1, 1)), new df.l(3, this), 1));
    }
}
