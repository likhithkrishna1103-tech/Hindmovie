package hd;

import android.os.Handler;
import androidx.emoji2.text.v;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import md.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements cd.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d8.j f5955a;

    public l(d8.j jVar) {
        this.f5955a = jVar;
    }

    @Override // cd.e
    public final void a(dd.e eVar, cd.b bVar, Throwable th) {
        ge.i.e(eVar, "download");
        ge.i.e(bVar, "error");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                ((Handler) jVar.f3556g).post(new i(jVar, eVar, 0));
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            dd.e eVar3 = eVar;
                            cd.b bVar2 = bVar;
                            Throwable th2 = th;
                            ((Handler) jVar.f3552b).post(new c8.a(eVar2, eVar3, bVar2, th2, 1));
                            eVar = eVar3;
                            bVar = bVar2;
                            th = th2;
                        }
                    }
                }
                dd.e eVar4 = eVar;
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar4.f3680z, eVar4, n.B);
                } else {
                    ((v) jVar.f3551a).u(eVar4.f3680z, eVar4, n.B);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar4.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // cd.e
    public final void b(dd.e eVar) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                ((Handler) jVar.f3556g).post(new i(jVar, eVar, 1));
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new h(eVar2, eVar, 1));
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.A);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.A);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void c(final dd.e eVar, final long j4, final long j7) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                ((Handler) jVar.f3556g).post(new i(jVar, eVar, 2));
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        final cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new Runnable() { // from class: hd.k
                                @Override // java.lang.Runnable
                                public final void run() {
                                    eVar2.c(eVar, j4, j7);
                                }
                            });
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.f8450z);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.f8450z);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void d(dd.e eVar, List list, int i) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                ((Handler) jVar.f3556g).post(new i(jVar, eVar, 3));
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new d8.e(eVar2, eVar, list, i));
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.f8448x);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.f8448x);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list2 = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list2 != null) {
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void e(dd.e eVar) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new h(eVar2, eVar, 2));
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.f8446v);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.f8446v);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void f(dd.e eVar, boolean z10) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new j(eVar2, eVar, z10));
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.f8447w);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.f8447w);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void g(dd.e eVar, md.b bVar, int i) {
        ge.i.e(eVar, "download");
        ge.i.e(bVar, "downloadBlock");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            eVar2.g(eVar, bVar, i);
                        }
                    }
                }
                if (!((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.C);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // cd.e
    public final void h(dd.e eVar) {
        ge.i.e(eVar, "download");
        d8.j jVar = this.f5955a;
        synchronized (jVar.f3553c) {
            try {
                Iterator it = ((LinkedHashMap) jVar.f3554d).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        cd.e eVar2 = (cd.e) ((WeakReference) it2.next()).get();
                        if (eVar2 == null) {
                            it2.remove();
                        } else {
                            ((Handler) jVar.f3552b).post(new h(eVar2, eVar, 0));
                        }
                    }
                }
                if (((LinkedHashMap) jVar.f3555e).isEmpty()) {
                    ((v) jVar.f3551a).z(eVar.f3680z, eVar, n.f8449y);
                } else {
                    ((v) jVar.f3551a).u(eVar.f3680z, eVar, n.f8449y);
                    Iterator it3 = ((LinkedHashMap) jVar.f3555e).values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            if (((WeakReference) it4.next()).get() != null) {
                                throw new ClassCastException();
                            }
                            it4.remove();
                        }
                    }
                }
                List list = (List) ((LinkedHashMap) jVar.f3557h).get(Integer.valueOf(eVar.f3676v));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        if (((WeakReference) it5.next()).get() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
