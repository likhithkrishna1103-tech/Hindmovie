package ge;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m implements le.c, fe.p {
    @Override // ge.d
    public final le.a c() {
        q.f5255a.getClass();
        return this;
    }

    public final void h() {
        if (this.B) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        le.a aVarF = f();
        if (aVarF == this) {
            throw new ee.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((l) ((le.c) aVarF)).h();
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        h();
        throw null;
    }
}
