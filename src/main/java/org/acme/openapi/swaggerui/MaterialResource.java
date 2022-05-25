package org.acme.openapi.swaggerui;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/Materials")
public class MaterialResource {

    private Set<Material> Materials = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public MaterialResource() {
        Materials.add(new Material("Apple", "Winter Material"));
        Materials.add(new Material("Pineapple", "Tropical Material"));
    }

    @GET
    public Set<Material> list() {
        return Materials;
    }

    @POST
    public Set<Material> add(Material Material) {
        Materials.add(Material);
        return Materials;
    }

    @DELETE
    public Set<Material> delete(Material Material) {
        Materials.removeIf(existingMaterial -> existingMaterial.name.contentEquals(Material.name));
        return Materials;
    }
}
