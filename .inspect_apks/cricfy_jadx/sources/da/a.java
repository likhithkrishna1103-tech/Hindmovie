package da;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Serializable f3564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Serializable f3565e;
    public Object f;

    public a(int i) {
        this.f3561a = i;
        switch (i) {
            case 1:
                this.f3562b = true;
                this.f3564d = "    ";
                this.f3565e = "type";
                this.f3563c = true;
                this.f = ef.a.f3890v;
                break;
            default:
                this.f3564d = new HashMap();
                this.f3565e = new HashSet();
                break;
        }
    }

    public boolean a(h hVar) {
        int id2 = hVar.getId();
        HashSet hashSet = (HashSet) this.f3565e;
        if (hashSet.contains(Integer.valueOf(id2))) {
            return false;
        }
        h hVar2 = (h) ((HashMap) this.f3564d).get(Integer.valueOf(c()));
        if (hVar2 != null) {
            e(hVar2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id2));
        if (!hVar.isChecked()) {
            hVar.setChecked(true);
        }
        return zAdd;
    }

    public ArrayList b(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet((HashSet) this.f3565e);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof h) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int c() {
        HashSet hashSet = (HashSet) this.f3565e;
        if (!this.f3562b || hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public void d() {
        m2.e eVar = (m2.e) this.f;
        if (eVar != null) {
            new HashSet((HashSet) this.f3565e);
            ChipGroup chipGroup = (ChipGroup) eVar.f8050v;
            v9.f fVar = chipGroup.B;
            if (fVar != null) {
                fVar.p(chipGroup.C.b(chipGroup));
            }
        }
    }

    public boolean e(h hVar, boolean z10) {
        int id2 = hVar.getId();
        HashSet hashSet = (HashSet) this.f3565e;
        if (!hashSet.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (z10 && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id2))) {
            hVar.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id2));
        if (hVar.isChecked()) {
            hVar.setChecked(false);
        }
        return zRemove;
    }

    public String toString() {
        switch (this.f3561a) {
            case 1:
                return "JsonConfiguration(encodeDefaults=false, ignoreUnknownKeys=false, isLenient=false, allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=" + this.f3562b + ", prettyPrintIndent='" + ((String) this.f3564d) + "', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='" + ((String) this.f3565e) + "', allowSpecialFloatingPointValues=false, useAlternativeNames=" + this.f3563c + ", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=" + ((ef.a) this.f) + ')';
            default:
                return super.toString();
        }
    }
}
