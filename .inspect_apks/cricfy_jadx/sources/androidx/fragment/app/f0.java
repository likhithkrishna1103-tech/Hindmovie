package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r0 f984v;

    public f0(r0 r0Var) {
        this.f984v = r0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        z0 z0VarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        r0 r0Var = this.f984v;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, r0Var);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o1.c.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(o1.c.Fragment_android_name);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(o1.c.Fragment_android_id, -1);
            String string = typedArrayObtainStyledAttributes.getString(o1.c.Fragment_android_tag);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = y.class.isAssignableFrom(k0.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id2 = view != null ? view.getId() : 0;
                    if (id2 == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    y yVarD = resourceId != -1 ? r0Var.D(resourceId) : null;
                    if (yVarD == null && string != null) {
                        yVarD = r0Var.E(string);
                    }
                    if (yVarD == null && id2 != -1) {
                        yVarD = r0Var.D(id2);
                    }
                    if (yVarD == null) {
                        k0 k0VarG = r0Var.G();
                        context.getClassLoader();
                        yVarD = k0VarG.a(attributeValue);
                        yVarD.I = true;
                        yVarD.R = resourceId != 0 ? resourceId : id2;
                        yVarD.S = id2;
                        yVarD.T = string;
                        yVarD.J = true;
                        yVarD.N = r0Var;
                        c0 c0Var = r0Var.f1062u;
                        yVarD.O = c0Var;
                        yVarD.B(c0Var.f952x, attributeSet, yVarD.f1119w);
                        z0VarF = r0Var.a(yVarD);
                        if (r0.J(2)) {
                            Log.v("FragmentManager", "Fragment " + yVarD + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (yVarD.J) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                        }
                        yVarD.J = true;
                        yVarD.N = r0Var;
                        c0 c0Var2 = r0Var.f1062u;
                        yVarD.O = c0Var2;
                        yVarD.B(c0Var2.f952x, attributeSet, yVarD.f1119w);
                        z0VarF = r0Var.f(yVarD);
                        if (r0.J(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + yVarD + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    p1.b bVar = p1.c.f9883a;
                    p1.c.b(new p1.a(yVarD, "Attempting to use <fragment> tag to add fragment " + yVarD + " to container " + viewGroup));
                    p1.c.a(yVarD).getClass();
                    yVarD.f1102a0 = viewGroup;
                    z0VarF.k();
                    z0VarF.j();
                    View view2 = yVarD.f1103b0;
                    if (view2 == null) {
                        throw new IllegalStateException(l0.e.k("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (yVarD.f1103b0.getTag() == null) {
                        yVarD.f1103b0.setTag(string);
                    }
                    yVarD.f1103b0.addOnAttachStateChangeListener(new e0(this, z0VarF));
                    return yVarD.f1103b0;
                }
            }
        }
        return null;
    }
}
