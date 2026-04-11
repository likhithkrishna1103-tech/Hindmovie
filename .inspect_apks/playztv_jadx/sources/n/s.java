package n;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Parcelable f8522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8526e;
    public final Object f;

    public /* synthetic */ s(TextView textView) {
        this.f8522a = null;
        this.f8523b = null;
        this.f8524c = false;
        this.f8525d = false;
        this.f = textView;
    }

    public void a() {
        CompoundButton compoundButton = (CompoundButton) this.f;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.f8524c || this.f8525d) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.f8524c) {
                    drawableMutate.setTintList((ColorStateList) this.f8522a);
                }
                if (this.f8525d) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f8523b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public void b() {
        r rVar = (r) this.f;
        Drawable checkMarkDrawable = rVar.getCheckMarkDrawable();
        if (checkMarkDrawable != null) {
            if (this.f8524c || this.f8525d) {
                Drawable drawableMutate = checkMarkDrawable.mutate();
                if (this.f8524c) {
                    drawableMutate.setTintList((ColorStateList) this.f8522a);
                }
                if (this.f8525d) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f8523b);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(rVar.getDrawableState());
                }
                rVar.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    public Bundle c(String str) {
        if (!this.f8525d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.f8522a;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.f8522a;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.f8522a;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f8522a = null;
        return bundle2;
    }

    public x4.c d() {
        String str;
        x4.c cVar;
        Iterator it = ((p.f) this.f).iterator();
        do {
            p.b bVar = (p.b) it;
            if (!bVar.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            be.h.d(entry, "components");
            str = (String) entry.getKey();
            cVar = (x4.c) entry.getValue();
        } while (!be.h.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return cVar;
    }

    public void e(AttributeSet attributeSet, int i) {
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = (CompoundButton) this.f;
        kc.b bVarD = kc.b.D(compoundButton.getContext(), attributeSet, g.j.CompoundButton, i);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        q0.o0.m(compoundButton, compoundButton.getContext(), g.j.CompoundButton, attributeSet, (TypedArray) bVarD.f7621w, i);
        try {
            if (typedArray.hasValue(g.j.CompoundButton_buttonCompat) && (resourceId2 = typedArray.getResourceId(g.j.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    compoundButton.setButtonDrawable(com.bumptech.glide.d.p(compoundButton.getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                    if (typedArray.hasValue(g.j.CompoundButton_android_button)) {
                        compoundButton.setButtonDrawable(com.bumptech.glide.d.p(compoundButton.getContext(), resourceId));
                    }
                }
            } else if (typedArray.hasValue(g.j.CompoundButton_android_button) && (resourceId = typedArray.getResourceId(g.j.CompoundButton_android_button, 0)) != 0) {
                compoundButton.setButtonDrawable(com.bumptech.glide.d.p(compoundButton.getContext(), resourceId));
            }
            if (typedArray.hasValue(g.j.CompoundButton_buttonTint)) {
                compoundButton.setButtonTintList(bVarD.q(g.j.CompoundButton_buttonTint));
            }
            if (typedArray.hasValue(g.j.CompoundButton_buttonTintMode)) {
                compoundButton.setButtonTintMode(n1.b(typedArray.getInt(g.j.CompoundButton_buttonTintMode, -1), null));
            }
            bVarD.E();
        } catch (Throwable th) {
            bVarD.E();
            throw th;
        }
    }

    public void f(String str, x4.c cVar) {
        Object obj;
        be.h.e(cVar, "provider");
        p.f fVar = (p.f) this.f;
        p.c cVarB = fVar.b(str);
        if (cVarB != null) {
            obj = cVarB.f9597v;
        } else {
            p.c cVar2 = new p.c(str, cVar);
            fVar.f9606x++;
            p.c cVar3 = fVar.f9604v;
            if (cVar3 == null) {
                fVar.f9603u = cVar2;
                fVar.f9604v = cVar2;
            } else {
                cVar3.f9598w = cVar2;
                cVar2.f9599x = cVar3;
                fVar.f9604v = cVar2;
            }
            obj = null;
        }
        if (((x4.c) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void g() {
        if (!this.f8526e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        h.h hVar = (h.h) this.f8523b;
        if (hVar == null) {
            hVar = new h.h(this);
        }
        this.f8523b = hVar;
        try {
            androidx.lifecycle.j.class.getDeclaredConstructor(null);
            h.h hVar2 = (h.h) this.f8523b;
            if (hVar2 != null) {
                ((LinkedHashSet) hVar2.f5499b).add(androidx.lifecycle.j.class.getName());
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + androidx.lifecycle.j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }

    public s() {
        this.f = new p.f();
        this.f8526e = true;
    }
}
