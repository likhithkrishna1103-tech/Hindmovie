package ne;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends sd.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ l7.a f9143v;

    public e(l7.a aVar) {
        this.f9143v = aVar;
    }

    @Override // sd.a
    public final int a() {
        return ((Matcher) this.f9143v.f7866w).groupCount() + 1;
    }

    @Override // sd.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        String strGroup = ((Matcher) this.f9143v.f7866w).group(i);
        return strGroup == null ? "" : strGroup;
    }

    @Override // sd.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // sd.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
