package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends l implements Iterable {
    public final v.l D;
    public int E;
    public String F;

    public n(o oVar) {
        super(oVar);
        this.D = new v.l();
    }

    @Override // androidx.navigation.l
    public final k c(androidx.emoji2.text.v vVar) {
        k kVarC = super.c(vVar);
        m mVar = new m(this);
        while (mVar.hasNext()) {
            k kVarC2 = ((l) mVar.next()).c(vVar);
            if (kVarC2 != null && (kVarC == null || kVarC2.compareTo(kVarC) > 0)) {
                kVarC = kVarC2;
            }
        }
        return kVarC;
    }

    @Override // androidx.navigation.l
    public final void d(Context context, AttributeSet attributeSet) {
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, n4.a.NavGraphNavigator);
        int resourceId = typedArrayObtainAttributes.getResourceId(n4.a.NavGraphNavigator_startDestination, 0);
        if (resourceId != this.f1371x) {
            this.E = resourceId;
            this.F = null;
            this.F = l.b(context, resourceId);
            typedArrayObtainAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("Start destination " + resourceId + " cannot use the same id as the graph " + this);
    }

    public final void f(l lVar) {
        int i = lVar.f1371x;
        if (i == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        }
        if (i == this.f1371x) {
            throw new IllegalArgumentException("Destination " + lVar + " cannot have the same id as graph " + this);
        }
        v.l lVar2 = this.D;
        l lVar3 = (l) lVar2.c(i);
        if (lVar3 == lVar) {
            return;
        }
        if (lVar.f1370w != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (lVar3 != null) {
            lVar3.f1370w = null;
        }
        lVar.f1370w = this;
        lVar2.d(lVar.f1371x, lVar);
    }

    public final l g(int i, boolean z10) {
        n nVar;
        l lVar = (l) this.D.c(i);
        if (lVar != null) {
            return lVar;
        }
        if (!z10 || (nVar = this.f1370w) == null) {
            return null;
        }
        return nVar.g(i, true);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new m(this);
    }

    @Override // androidx.navigation.l
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        l lVarG = g(this.E, true);
        if (lVarG == null) {
            String str = this.F;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.E));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(lVarG.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
