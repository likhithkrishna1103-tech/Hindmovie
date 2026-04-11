package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.google.android.gms.internal.measurement.k4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1288b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1289c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1290d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1291e = false;

    public j(ViewGroup viewGroup) {
        this.f1287a = viewGroup;
    }

    public static j f(ViewGroup viewGroup, q9.e eVar) {
        Object tag = viewGroup.getTag(i1.b.special_effects_controller_view_tag);
        if (tag instanceof j) {
            return (j) tag;
        }
        eVar.getClass();
        j jVar = new j(viewGroup);
        viewGroup.setTag(i1.b.special_effects_controller_view_tag, jVar);
        return jVar;
    }

    public final void a(int i, int i10, u0 u0Var) {
        synchronized (this.f1288b) {
            try {
                m0.c cVar = new m0.c();
                z0 z0VarD = d(u0Var.f1374c);
                if (z0VarD != null) {
                    z0VarD.c(i, i10);
                    return;
                }
                z0 z0Var = new z0(i, i10, u0Var, cVar);
                this.f1288b.add(z0Var);
                z0Var.f1430d.add(new y0(this, z0Var, 0));
                z0Var.f1430d.add(new y0(this, z0Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(ArrayList arrayList, boolean z2) {
        boolean z10;
        ViewGroup viewGroup;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        z0 z0Var = null;
        z0 z0Var2 = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            z0 z0Var3 = (z0) obj;
            int iC = l4.a.c(z0Var3.f1429c.f1378a0);
            int iC2 = v.e.c(z0Var3.f1427a);
            if (iC2 != 0) {
                if (iC2 != 1) {
                    if (iC2 == 2 || iC2 == 3) {
                    }
                } else if (iC != 2) {
                    z0Var2 = z0Var3;
                }
            }
            if (iC == 2 && z0Var == null) {
                z0Var = z0Var3;
            }
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "Executing operations from " + z0Var + " to " + z0Var2);
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList(arrayList2);
        v vVar = ((z0) arrayList2.get(arrayList2.size() - 1)).f1429c;
        int size2 = arrayList2.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj2 = arrayList2.get(i10);
            i10++;
            t tVar = ((z0) obj2).f1429c.f1381d0;
            t tVar2 = vVar.f1381d0;
            tVar.f1362b = tVar2.f1362b;
            tVar.f1363c = tVar2.f1363c;
            tVar.f1364d = tVar2.f1364d;
            tVar.f1365e = tVar2.f1365e;
        }
        int size3 = arrayList2.size();
        int i11 = 0;
        while (i11 < size3) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            z0 z0Var4 = (z0) obj3;
            m0.c cVar = new m0.c();
            z0Var4.d();
            HashSet hashSet = z0Var4.f1431e;
            hashSet.add(cVar);
            g gVar = new g(z0Var4, cVar);
            gVar.f1279d = false;
            gVar.f1278c = z2;
            arrayList3.add(gVar);
            m0.c cVar2 = new m0.c();
            z0Var4.d();
            hashSet.add(cVar2);
            boolean z11 = !z2 ? z0Var4 != z0Var2 : z0Var4 != z0Var;
            i iVar = new i(z0Var4, cVar2);
            int i12 = z0Var4.f1427a;
            v vVar2 = z0Var4.f1429c;
            if (i12 == 2) {
                if (z2) {
                    t tVar3 = vVar2.f1381d0;
                } else {
                    vVar2.getClass();
                }
                if (z2) {
                    t tVar4 = vVar2.f1381d0;
                } else {
                    t tVar5 = vVar2.f1381d0;
                }
            } else if (z2) {
                t tVar6 = vVar2.f1381d0;
            } else {
                vVar2.getClass();
            }
            if (z11) {
                if (z2) {
                    t tVar7 = vVar2.f1381d0;
                } else {
                    vVar2.getClass();
                }
            }
            arrayList4.add(iVar);
            z0Var4.f1430d.add(new ea.t(this, arrayList5, z0Var4));
            arrayList2 = arrayList;
        }
        HashMap map = new HashMap();
        int size4 = arrayList4.size();
        int i13 = 0;
        while (i13 < size4) {
            Object obj4 = arrayList4.get(i13);
            i13++;
            z0 z0Var5 = (z0) ((i) obj4).f1282a;
            if (l4.a.c(z0Var5.f1429c.f1378a0) != z0Var5.f1427a) {
            }
        }
        int size5 = arrayList4.size();
        int i14 = 0;
        while (i14 < size5) {
            Object obj5 = arrayList4.get(i14);
            i14++;
            i iVar2 = (i) obj5;
            map.put((z0) iVar2.f1282a, Boolean.FALSE);
            iVar2.d();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup2 = this.f1287a;
        Context context = viewGroup2.getContext();
        ArrayList arrayList6 = new ArrayList();
        int size6 = arrayList3.size();
        boolean z12 = false;
        int i15 = 0;
        while (i15 < size6) {
            Object obj6 = arrayList3.get(i15);
            i15++;
            g gVar2 = (g) obj6;
            boolean z13 = zContainsValue;
            z0 z0Var6 = (z0) gVar2.f1282a;
            ArrayList arrayList7 = arrayList3;
            int iC3 = l4.a.c(z0Var6.f1429c.f1378a0);
            int i16 = z0Var6.f1427a;
            int i17 = size6;
            if (iC3 == i16 || !(iC3 == 2 || i16 == 2)) {
                z10 = z12;
                viewGroup = viewGroup2;
                gVar2.d();
                zContainsValue = z13;
                size6 = i17;
                viewGroup2 = viewGroup;
                arrayList3 = arrayList7;
                z12 = z10;
            } else {
                k4 k4VarN = gVar2.n(context);
                if (k4VarN == null) {
                    gVar2.d();
                } else {
                    Animator animator = (Animator) k4VarN.f3071v;
                    if (animator == null) {
                        arrayList6.add(gVar2);
                    } else {
                        z0 z0Var7 = (z0) gVar2.f1282a;
                        v vVar3 = z0Var7.f1429c;
                        z10 = z12;
                        if (Boolean.TRUE.equals(map.get(z0Var7))) {
                            if (n0.G(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + vVar3 + " as this Fragment was involved in a Transition.");
                            }
                            gVar2.d();
                            viewGroup = viewGroup2;
                            zContainsValue = z13;
                            size6 = i17;
                            viewGroup2 = viewGroup;
                            arrayList3 = arrayList7;
                            z12 = z10;
                        } else {
                            boolean z14 = z0Var7.f1427a == 3;
                            if (z14) {
                                arrayList5.remove(z0Var7);
                            }
                            View view = vVar3.f1378a0;
                            viewGroup2.startViewTransition(view);
                            ViewGroup viewGroup3 = viewGroup2;
                            animator.addListener(new d(viewGroup3, view, z14, z0Var7, gVar2));
                            animator.setTarget(view);
                            animator.start();
                            if (n0.G(2)) {
                                Log.v("FragmentManager", "Animator from operation " + z0Var7 + " has started.");
                            }
                            ((m0.c) gVar2.f1283b).a(new h4.z(animator, 2, z0Var7));
                            zContainsValue = z13;
                            size6 = i17;
                            viewGroup2 = viewGroup3;
                            arrayList3 = arrayList7;
                            z12 = true;
                        }
                    }
                }
                z10 = z12;
                viewGroup = viewGroup2;
                zContainsValue = z13;
                size6 = i17;
                viewGroup2 = viewGroup;
                arrayList3 = arrayList7;
                z12 = z10;
            }
        }
        boolean z15 = zContainsValue;
        boolean z16 = z12;
        ViewGroup viewGroup4 = viewGroup2;
        int size7 = arrayList6.size();
        int i18 = 0;
        while (i18 < size7) {
            Object obj7 = arrayList6.get(i18);
            i18++;
            g gVar3 = (g) obj7;
            z0 z0Var8 = (z0) gVar3.f1282a;
            v vVar4 = z0Var8.f1429c;
            if (z15) {
                if (n0.G(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + vVar4 + " as Animations cannot run alongside Transitions.");
                }
                gVar3.d();
            } else if (z16) {
                if (n0.G(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + vVar4 + " as Animations cannot run alongside Animators.");
                }
                gVar3.d();
            } else {
                View view2 = vVar4.f1378a0;
                k4 k4VarN2 = gVar3.n(context);
                k4VarN2.getClass();
                Animation animation = (Animation) k4VarN2.f3070u;
                animation.getClass();
                int i19 = size7;
                if (z0Var8.f1427a != 1) {
                    view2.startAnimation(animation);
                    gVar3.d();
                } else {
                    viewGroup4.startViewTransition(view2);
                    a0 a0Var = new a0(animation, viewGroup4, view2);
                    a0Var.setAnimationListener(new f(z0Var8, viewGroup4, view2, gVar3));
                    view2.startAnimation(a0Var);
                    if (n0.G(2)) {
                        Log.v("FragmentManager", "Animation from operation " + z0Var8 + " has started.");
                    }
                }
                ViewGroup viewGroup5 = viewGroup4;
                ((m0.c) gVar3.f1283b).a(new ub.o(view2, viewGroup5, gVar3, z0Var8, 2));
                size7 = i19;
                viewGroup4 = viewGroup5;
            }
        }
        int size8 = arrayList5.size();
        int i20 = 0;
        while (i20 < size8) {
            Object obj8 = arrayList5.get(i20);
            i20++;
            z0 z0Var9 = (z0) obj8;
            l4.a.a(z0Var9.f1429c.f1378a0, z0Var9.f1427a);
        }
        arrayList5.clear();
        if (n0.G(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + z0Var + " to " + z0Var2);
        }
    }

    public final void c() {
        if (this.f1291e) {
            return;
        }
        ViewGroup viewGroup = this.f1287a;
        WeakHashMap weakHashMap = q0.o0.f10475a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f1290d = false;
            return;
        }
        synchronized (this.f1288b) {
            try {
                if (!this.f1288b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f1289c);
                    this.f1289c.clear();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        z0 z0Var = (z0) obj;
                        if (n0.G(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + z0Var);
                        }
                        z0Var.a();
                        if (!z0Var.f1432g) {
                            this.f1289c.add(z0Var);
                        }
                    }
                    g();
                    ArrayList arrayList2 = new ArrayList(this.f1288b);
                    this.f1288b.clear();
                    this.f1289c.addAll(arrayList2);
                    if (n0.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayList2.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj2 = arrayList2.get(i10);
                        i10++;
                        ((z0) obj2).d();
                    }
                    b(arrayList2, this.f1290d);
                    this.f1290d = false;
                    if (n0.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final z0 d(v vVar) {
        ArrayList arrayList = this.f1288b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            z0 z0Var = (z0) obj;
            if (z0Var.f1429c.equals(vVar) && !z0Var.f) {
                return z0Var;
            }
        }
        return null;
    }

    public final void e() {
        String str;
        String str2;
        if (n0.G(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f1287a;
        WeakHashMap weakHashMap = q0.o0.f10475a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f1288b) {
            try {
                g();
                ArrayList arrayList = this.f1288b;
                int size = arrayList.size();
                int i = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((z0) obj).d();
                }
                ArrayList arrayList2 = new ArrayList(this.f1289c);
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    z0 z0Var = (z0) obj2;
                    if (n0.G(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f1287a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(z0Var);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    z0Var.a();
                }
                ArrayList arrayList3 = new ArrayList(this.f1288b);
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    z0 z0Var2 = (z0) obj3;
                    if (n0.G(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f1287a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(z0Var2);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    z0Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f1288b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            z0 z0Var = (z0) obj;
            if (z0Var.f1428b == 2) {
                z0Var.c(l4.a.b(z0Var.f1429c.I().getVisibility()), 1);
            }
        }
    }
}
