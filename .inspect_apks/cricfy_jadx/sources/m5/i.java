package m5;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f8331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8335e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8337h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f8338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f8339k;

    public i() {
        this.f8331a = new Matrix();
        this.f8332b = new ArrayList();
        this.f8333c = 0.0f;
        this.f8334d = 0.0f;
        this.f8335e = 0.0f;
        this.f = 1.0f;
        this.f8336g = 1.0f;
        this.f8337h = 0.0f;
        this.i = 0.0f;
        this.f8338j = new Matrix();
        this.f8339k = null;
    }

    @Override // m5.j
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f8332b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((j) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // m5.j
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f8332b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((j) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.f8338j;
        matrix.reset();
        matrix.postTranslate(-this.f8334d, -this.f8335e);
        matrix.postScale(this.f, this.f8336g);
        matrix.postRotate(this.f8333c, 0.0f, 0.0f);
        matrix.postTranslate(this.f8337h + this.f8334d, this.i + this.f8335e);
    }

    public String getGroupName() {
        return this.f8339k;
    }

    public Matrix getLocalMatrix() {
        return this.f8338j;
    }

    public float getPivotX() {
        return this.f8334d;
    }

    public float getPivotY() {
        return this.f8335e;
    }

    public float getRotation() {
        return this.f8333c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.f8336g;
    }

    public float getTranslateX() {
        return this.f8337h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.f8334d) {
            this.f8334d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.f8335e) {
            this.f8335e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.f8333c) {
            this.f8333c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.f8336g) {
            this.f8336g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f8337h) {
            this.f8337h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public i(i iVar, v.e eVar) {
        k gVar;
        this.f8331a = new Matrix();
        this.f8332b = new ArrayList();
        this.f8333c = 0.0f;
        this.f8334d = 0.0f;
        this.f8335e = 0.0f;
        this.f = 1.0f;
        this.f8336g = 1.0f;
        this.f8337h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.f8338j = matrix;
        this.f8339k = null;
        this.f8333c = iVar.f8333c;
        this.f8334d = iVar.f8334d;
        this.f8335e = iVar.f8335e;
        this.f = iVar.f;
        this.f8336g = iVar.f8336g;
        this.f8337h = iVar.f8337h;
        this.i = iVar.i;
        String str = iVar.f8339k;
        this.f8339k = str;
        if (str != null) {
            eVar.put(str, this);
        }
        matrix.set(iVar.f8338j);
        ArrayList arrayList = iVar.f8332b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof i) {
                this.f8332b.add(new i((i) obj, eVar));
            } else {
                if (obj instanceof h) {
                    h hVar = (h) obj;
                    h hVar2 = new h(hVar);
                    hVar2.f8323e = 0.0f;
                    hVar2.f8324g = 1.0f;
                    hVar2.f8325h = 1.0f;
                    hVar2.i = 0.0f;
                    hVar2.f8326j = 1.0f;
                    hVar2.f8327k = 0.0f;
                    hVar2.f8328l = Paint.Cap.BUTT;
                    hVar2.f8329m = Paint.Join.MITER;
                    hVar2.f8330n = 4.0f;
                    hVar2.f8322d = hVar.f8322d;
                    hVar2.f8323e = hVar.f8323e;
                    hVar2.f8324g = hVar.f8324g;
                    hVar2.f = hVar.f;
                    hVar2.f8342c = hVar.f8342c;
                    hVar2.f8325h = hVar.f8325h;
                    hVar2.i = hVar.i;
                    hVar2.f8326j = hVar.f8326j;
                    hVar2.f8327k = hVar.f8327k;
                    hVar2.f8328l = hVar.f8328l;
                    hVar2.f8329m = hVar.f8329m;
                    hVar2.f8330n = hVar.f8330n;
                    gVar = hVar2;
                } else if (obj instanceof g) {
                    gVar = new g((g) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f8332b.add(gVar);
                Object obj2 = gVar.f8341b;
                if (obj2 != null) {
                    eVar.put(obj2, gVar);
                }
            }
        }
    }
}
