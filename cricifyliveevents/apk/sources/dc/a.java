package dc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3653a;

    public a(int i) {
        this.f3653a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return e.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        if (this.f3653a != ((a) ((e) obj)).f3653a) {
            return false;
        }
        Object obj2 = d.f3655v;
        return obj2.equals(obj2);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.f3653a) + (d.f3655v.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f3653a + "intEncoding=" + d.f3655v + ')';
    }
}
