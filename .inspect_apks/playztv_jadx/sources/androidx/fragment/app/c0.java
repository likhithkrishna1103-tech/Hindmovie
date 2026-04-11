package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n0 f1257u;

    public c0(n0 n0Var) {
        this.f1257u = n0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        u0 u0VarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        n0 n0Var = this.f1257u;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, n0Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i1.c.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(i1.c.Fragment_android_name);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(i1.c.Fragment_android_id, -1);
            String string = typedArrayObtainStyledAttributes.getString(i1.c.Fragment_android_tag);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = v.class.isAssignableFrom(h0.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id2 = view != null ? view.getId() : 0;
                    if (id2 == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    v vVarA = resourceId != -1 ? n0Var.A(resourceId) : null;
                    if (vVarA == null && string != null) {
                        vVarA = n0Var.B(string);
                    }
                    if (vVarA == null && id2 != -1) {
                        vVarA = n0Var.A(id2);
                    }
                    if (vVarA == null) {
                        h0 h0VarD = n0Var.D();
                        context.getClassLoader();
                        vVarA = h0VarD.a(attributeValue);
                        vVarA.H = true;
                        vVarA.Q = resourceId != 0 ? resourceId : id2;
                        vVarA.R = id2;
                        vVarA.S = string;
                        vVarA.I = true;
                        vVarA.M = n0Var;
                        z zVar = n0Var.f1327t;
                        vVarA.N = zVar;
                        h.j jVar = zVar.f1423v;
                        vVarA.Y = true;
                        if ((zVar != null ? zVar.f1422u : null) != null) {
                            vVarA.Y = true;
                        }
                        u0VarF = n0Var.a(vVarA);
                        if (n0.G(2)) {
                            Log.v("FragmentManager", "Fragment " + vVarA + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (vVarA.I) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                        }
                        vVarA.I = true;
                        vVarA.M = n0Var;
                        z zVar2 = n0Var.f1327t;
                        vVarA.N = zVar2;
                        h.j jVar2 = zVar2.f1423v;
                        vVarA.Y = true;
                        if ((zVar2 != null ? zVar2.f1422u : null) != null) {
                            vVarA.Y = true;
                        }
                        u0VarF = n0Var.f(vVarA);
                        if (n0.G(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + vVarA + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    j1.b bVar = j1.c.f6667a;
                    j1.c.b(new j1.a(vVarA, "Attempting to use <fragment> tag to add fragment " + vVarA + " to container " + viewGroup));
                    j1.c.a(vVarA).getClass();
                    vVarA.Z = viewGroup;
                    u0VarF.k();
                    u0VarF.j();
                    View view2 = vVarA.f1378a0;
                    if (view2 == null) {
                        throw new IllegalStateException(e6.j.n("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (vVarA.f1378a0.getTag() == null) {
                        vVarA.f1378a0.setTag(string);
                    }
                    vVarA.f1378a0.addOnAttachStateChangeListener(new b0(this, u0VarF));
                    return vVarA.f1378a0;
                }
            }
        }
        return null;
    }
}
