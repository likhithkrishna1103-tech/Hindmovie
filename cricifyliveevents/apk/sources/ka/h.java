package ka;

import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends w4.v {
    public final int i;

    public h(int i) {
        this.i = i;
    }

    @Override // w4.v
    public final float j(w wVar) {
        float[] fArr = ((i) wVar).X;
        if (fArr != null) {
            return fArr[this.i];
        }
        return 0.0f;
    }

    @Override // w4.v
    public final void u(w wVar, float f) {
        i iVar = (i) wVar;
        float[] fArr = iVar.X;
        if (fArr != null) {
            int i = this.i;
            if (fArr[i] != f) {
                fArr[i] = f;
                kb.d dVar = iVar.Z;
                if (dVar != null) {
                    float fI = iVar.i();
                    MaterialButton materialButton = (MaterialButton) dVar.f7399w;
                    int i10 = (int) (fI * 0.11f);
                    if (materialButton.S != i10) {
                        materialButton.S = i10;
                        materialButton.j();
                        materialButton.invalidate();
                    }
                }
                iVar.invalidateSelf();
            }
        }
    }
}
