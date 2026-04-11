package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f1014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1018e;

    public l(ViewGroup viewGroup) {
        ge.i.e(viewGroup, "container");
        this.f1014a = viewGroup;
        this.f1015b = new ArrayList();
        this.f1016c = new ArrayList();
    }

    public static final l f(ViewGroup viewGroup, r0 r0Var) {
        ge.i.e(viewGroup, "container");
        ge.i.e(r0Var, "fragmentManager");
        ge.i.d(r0Var.H(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = viewGroup.getTag(o1.b.special_effects_controller_view_tag);
        if (tag instanceof l) {
            return (l) tag;
        }
        l lVar = new l(viewGroup);
        viewGroup.setTag(o1.b.special_effects_controller_view_tag, lVar);
        return lVar;
    }

    public final void a(int i, int i10, z0 z0Var) {
        synchronized (this.f1015b) {
            p0.c cVar = new p0.c();
            y yVar = z0Var.f1129c;
            ge.i.d(yVar, "fragmentStateManager.fragment");
            e1 e1VarD = d(yVar);
            if (e1VarD != null) {
                e1VarD.c(i, i10);
                return;
            }
            final e1 e1Var = new e1(i, i10, z0Var, cVar);
            this.f1015b.add(e1Var);
            final int i11 = 0;
            e1Var.f976d.add(new Runnable(this) { // from class: androidx.fragment.app.d1

                /* JADX INFO: renamed from: w, reason: collision with root package name */
                public final /* synthetic */ l f966w;

                {
                    this.f966w = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i11) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            ArrayList arrayList = this.f966w.f1015b;
                            e1 e1Var2 = e1Var;
                            if (arrayList.contains(e1Var2)) {
                                int i12 = e1Var2.f973a;
                                View view = e1Var2.f975c.f1103b0;
                                ge.i.d(view, "operation.fragment.mView");
                                q4.a.b(view, i12);
                            }
                            break;
                        default:
                            l lVar = this.f966w;
                            ArrayList arrayList2 = lVar.f1015b;
                            e1 e1Var3 = e1Var;
                            arrayList2.remove(e1Var3);
                            lVar.f1016c.remove(e1Var3);
                            break;
                    }
                }
            });
            final int i12 = 1;
            e1Var.f976d.add(new Runnable(this) { // from class: androidx.fragment.app.d1

                /* JADX INFO: renamed from: w, reason: collision with root package name */
                public final /* synthetic */ l f966w;

                {
                    this.f966w = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i12) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            ArrayList arrayList = this.f966w.f1015b;
                            e1 e1Var2 = e1Var;
                            if (arrayList.contains(e1Var2)) {
                                int i122 = e1Var2.f973a;
                                View view = e1Var2.f975c.f1103b0;
                                ge.i.d(view, "operation.fragment.mView");
                                q4.a.b(view, i122);
                            }
                            break;
                        default:
                            l lVar = this.f966w;
                            ArrayList arrayList2 = lVar.f1015b;
                            e1 e1Var3 = e1Var;
                            arrayList2.remove(e1Var3);
                            lVar.f1016c.remove(e1Var3);
                            break;
                    }
                }
            });
        }
    }

    public final void b(ArrayList arrayList, boolean z10) {
        Object obj;
        Object obj2;
        String str;
        ArrayList arrayList2;
        int i;
        boolean z11;
        ArrayList arrayList3 = arrayList;
        int size = arrayList3.size();
        int i10 = 0;
        while (true) {
            obj = null;
            if (i10 >= size) {
                obj2 = null;
                break;
            }
            obj2 = arrayList3.get(i10);
            i10++;
            e1 e1Var = (e1) obj2;
            View view = e1Var.f975c.f1103b0;
            ge.i.d(view, "operation.fragment.mView");
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility != 0) {
                    if (visibility != 4 && visibility != 8) {
                        throw new IllegalArgumentException(l0.e.g(visibility, "Unknown visibility "));
                    }
                } else if (e1Var.f973a != 2) {
                    break;
                }
            }
        }
        e1 e1Var2 = (e1) obj2;
        ListIterator listIterator = arrayList3.listIterator(arrayList3.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object objPrevious = listIterator.previous();
            e1 e1Var3 = (e1) objPrevious;
            View view2 = e1Var3.f975c.f1103b0;
            ge.i.d(view2, "operation.fragment.mView");
            if (view2.getAlpha() != 0.0f || view2.getVisibility() != 0) {
                int visibility2 = view2.getVisibility();
                if (visibility2 == 0) {
                    continue;
                } else if (visibility2 != 4 && visibility2 != 8) {
                    throw new IllegalArgumentException(l0.e.g(visibility2, "Unknown visibility "));
                }
            }
            if (e1Var3.f973a == 2) {
                obj = objPrevious;
                break;
            }
        }
        e1 e1Var4 = (e1) obj;
        if (r0.J(2)) {
            Log.v("FragmentManager", "Executing operations from " + e1Var2 + " to " + e1Var4);
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayListS0 = sd.j.s0(arrayList3);
        y yVar = ((e1) sd.j.m0(arrayList3)).f975c;
        int size2 = arrayList3.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj3 = arrayList3.get(i11);
            i11++;
            w wVar = ((e1) obj3).f975c.f1106e0;
            w wVar2 = yVar.f1106e0;
            wVar.f1088b = wVar2.f1088b;
            wVar.f1089c = wVar2.f1089c;
            wVar.f1090d = wVar2.f1090d;
            wVar.f1091e = wVar2.f1091e;
        }
        int size3 = arrayList3.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj4 = arrayList3.get(i12);
            i12++;
            e1 e1Var5 = (e1) obj4;
            p0.c cVar = new p0.c();
            e1Var5.d();
            LinkedHashSet linkedHashSet = e1Var5.f977e;
            linkedHashSet.add(cVar);
            arrayList4.add(new g(e1Var5, cVar, z10));
            p0.c cVar2 = new p0.c();
            e1Var5.d();
            linkedHashSet.add(cVar2);
            boolean z12 = !z10 ? e1Var5 != e1Var4 : e1Var5 != e1Var2;
            y yVar2 = e1Var5.f975c;
            i iVar = new i(e1Var5, cVar2);
            if (e1Var5.f973a == 2) {
                if (z10) {
                    w wVar3 = yVar2.f1106e0;
                } else {
                    yVar2.getClass();
                }
            } else if (z10) {
                w wVar4 = yVar2.f1106e0;
            } else {
                yVar2.getClass();
            }
            if (e1Var5.f973a == 2) {
                if (z10) {
                    w wVar5 = yVar2.f1106e0;
                } else {
                    w wVar6 = yVar2.f1106e0;
                }
            }
            if (z12) {
                if (z10) {
                    w wVar7 = yVar2.f1106e0;
                } else {
                    yVar2.getClass();
                }
            }
            arrayList5.add(iVar);
            e1Var5.f976d.add(new d(arrayListS0, e1Var5, this));
            arrayList3 = arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList6 = new ArrayList();
        int size4 = arrayList5.size();
        int i13 = 0;
        while (i13 < size4) {
            Object obj5 = arrayList5.get(i13);
            i13++;
            if (!((i) obj5).l()) {
                arrayList6.add(obj5);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        int size5 = arrayList6.size();
        int i14 = 0;
        while (i14 < size5) {
            Object obj6 = arrayList6.get(i14);
            i14++;
            ((i) obj6).getClass();
        }
        int size6 = arrayList7.size();
        int i15 = 0;
        while (i15 < size6) {
            Object obj7 = arrayList7.get(i15);
            i15++;
            ((i) obj7).getClass();
        }
        int size7 = arrayList5.size();
        int i16 = 0;
        while (i16 < size7) {
            Object obj8 = arrayList5.get(i16);
            i16++;
            i iVar2 = (i) obj8;
            linkedHashMap.put((e1) iVar2.f993a, Boolean.FALSE);
            iVar2.d();
        }
        boolean zContainsValue = linkedHashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.f1014a;
        Context context = viewGroup.getContext();
        ArrayList arrayList8 = new ArrayList();
        int size8 = arrayList4.size();
        boolean z13 = false;
        int i17 = 0;
        while (true) {
            str = "context";
            if (i17 >= size8) {
                break;
            }
            int i18 = i17 + 1;
            g gVar = (g) arrayList4.get(i17);
            if (gVar.l()) {
                gVar.d();
            } else {
                ge.i.d(context, "context");
                l4.c0 c0VarO = gVar.o(context);
                if (c0VarO == null) {
                    gVar.d();
                } else {
                    Animator animator = (Animator) c0VarO.f7706x;
                    if (animator == null) {
                        arrayList8.add(gVar);
                    } else {
                        arrayList2 = arrayList8;
                        e1 e1Var6 = (e1) gVar.f993a;
                        y yVar3 = e1Var6.f975c;
                        i = size8;
                        z11 = z13;
                        if (ge.i.a(linkedHashMap.get(e1Var6), Boolean.TRUE)) {
                            if (r0.J(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + yVar3 + " as this Fragment was involved in a Transition.");
                            }
                            gVar.d();
                            arrayList8 = arrayList2;
                            size8 = i;
                            i17 = i18;
                            z13 = z11;
                        } else {
                            boolean z14 = e1Var6.f973a == 3;
                            if (z14) {
                                arrayListS0.remove(e1Var6);
                            }
                            View view3 = yVar3.f1103b0;
                            viewGroup.startViewTransition(view3);
                            LinkedHashMap linkedHashMap2 = linkedHashMap;
                            ArrayList arrayList9 = arrayList4;
                            animator.addListener(new j(this, view3, z14, e1Var6, gVar));
                            animator.setTarget(view3);
                            animator.start();
                            if (r0.J(2)) {
                                Log.v("FragmentManager", "Animator from operation " + e1Var6 + " has started.");
                            }
                            ((p0.c) gVar.f994b).a(new e(0, animator, e1Var6));
                            linkedHashMap = linkedHashMap2;
                            size8 = i;
                            i17 = i18;
                            arrayList8 = arrayList2;
                            arrayList4 = arrayList9;
                            z13 = true;
                        }
                    }
                }
            }
            arrayList2 = arrayList8;
            i = size8;
            z11 = z13;
            arrayList8 = arrayList2;
            size8 = i;
            i17 = i18;
            z13 = z11;
        }
        ArrayList arrayList10 = arrayList8;
        boolean z15 = z13;
        int size9 = arrayList10.size();
        int i19 = 0;
        while (i19 < size9) {
            ArrayList arrayList11 = arrayList10;
            Object obj9 = arrayList11.get(i19);
            int i20 = i19 + 1;
            g gVar2 = (g) obj9;
            e1 e1Var7 = (e1) gVar2.f993a;
            int i21 = size9;
            y yVar4 = e1Var7.f975c;
            if (zContainsValue) {
                if (r0.J(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + yVar4 + " as Animations cannot run alongside Transitions.");
                }
                gVar2.d();
            } else if (z15) {
                if (r0.J(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + yVar4 + " as Animations cannot run alongside Animators.");
                }
                gVar2.d();
            } else {
                View view4 = yVar4.f1103b0;
                ge.i.d(context, str);
                l4.c0 c0VarO2 = gVar2.o(context);
                String str2 = str;
                if (c0VarO2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                Animation animation = (Animation) c0VarO2.f7705w;
                if (animation == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                arrayList10 = arrayList11;
                if (e1Var7.f973a != 1) {
                    view4.startAnimation(animation);
                    gVar2.d();
                } else {
                    viewGroup.startViewTransition(view4);
                    d0 d0Var = new d0(animation, viewGroup, view4);
                    d0Var.setAnimationListener(new k(e1Var7, this, view4, gVar2));
                    view4.startAnimation(d0Var);
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "Animation from operation " + e1Var7 + " has started.");
                    }
                }
                ((p0.c) gVar2.f994b).a(new f(view4, this, gVar2, e1Var7));
                size9 = i21;
                i19 = i20;
                str = str2;
            }
            size9 = i21;
            i19 = i20;
            arrayList10 = arrayList11;
        }
        int size10 = arrayListS0.size();
        int i22 = 0;
        while (i22 < size10) {
            Object obj10 = arrayListS0.get(i22);
            i22++;
            e1 e1Var8 = (e1) obj10;
            View view5 = e1Var8.f975c.f1103b0;
            int i23 = e1Var8.f973a;
            ge.i.d(view5, "view");
            q4.a.b(view5, i23);
        }
        arrayListS0.clear();
        if (r0.J(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + e1Var2 + " to " + e1Var4);
        }
    }

    public final void c() {
        if (this.f1018e) {
            return;
        }
        ViewGroup viewGroup = this.f1014a;
        WeakHashMap weakHashMap = t0.m0.f11777a;
        if (!viewGroup.isAttachedToWindow()) {
            e();
            this.f1017d = false;
            return;
        }
        synchronized (this.f1015b) {
            try {
                if (!this.f1015b.isEmpty()) {
                    ArrayList arrayListS0 = sd.j.s0(this.f1016c);
                    this.f1016c.clear();
                    int size = arrayListS0.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayListS0.get(i);
                        i++;
                        e1 e1Var = (e1) obj;
                        if (r0.J(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + e1Var);
                        }
                        e1Var.a();
                        if (!e1Var.f978g) {
                            this.f1016c.add(e1Var);
                        }
                    }
                    g();
                    ArrayList arrayListS02 = sd.j.s0(this.f1015b);
                    this.f1015b.clear();
                    this.f1016c.addAll(arrayListS02);
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    int size2 = arrayListS02.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj2 = arrayListS02.get(i10);
                        i10++;
                        ((e1) obj2).d();
                    }
                    b(arrayListS02, this.f1017d);
                    this.f1017d = false;
                    if (r0.J(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final e1 d(y yVar) {
        Object obj;
        ArrayList arrayList = this.f1015b;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i);
            i++;
            e1 e1Var = (e1) obj;
            if (ge.i.a(e1Var.f975c, yVar) && !e1Var.f) {
                break;
            }
        }
        return (e1) obj;
    }

    public final void e() {
        String str;
        String str2;
        if (r0.J(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.f1014a;
        WeakHashMap weakHashMap = t0.m0.f11777a;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f1015b) {
            try {
                g();
                ArrayList arrayList = this.f1015b;
                int size = arrayList.size();
                int i = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((e1) obj).d();
                }
                ArrayList arrayListS0 = sd.j.s0(this.f1016c);
                int size2 = arrayListS0.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayListS0.get(i11);
                    i11++;
                    e1 e1Var = (e1) obj2;
                    if (r0.J(2)) {
                        if (zIsAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f1014a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str2 + "Cancelling running operation " + e1Var);
                    }
                    e1Var.a();
                }
                ArrayList arrayListS02 = sd.j.s0(this.f1015b);
                int size3 = arrayListS02.size();
                while (i < size3) {
                    Object obj3 = arrayListS02.get(i);
                    i++;
                    e1 e1Var2 = (e1) obj3;
                    if (r0.J(2)) {
                        if (zIsAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.f1014a + " is not attached to window. ";
                        }
                        Log.v("FragmentManager", "SpecialEffectsController: " + str + "Cancelling pending operation " + e1Var2);
                    }
                    e1Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.f1015b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            e1 e1Var = (e1) obj;
            int i10 = 2;
            if (e1Var.f974b == 2) {
                int visibility = e1Var.f975c.L().getVisibility();
                if (visibility != 0) {
                    i10 = 4;
                    if (visibility != 4) {
                        if (visibility != 8) {
                            throw new IllegalArgumentException(l0.e.g(visibility, "Unknown visibility "));
                        }
                        i10 = 3;
                    }
                }
                e1Var.c(i10, 1);
            }
        }
    }
}
