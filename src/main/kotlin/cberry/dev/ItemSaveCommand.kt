package cberry.dev

import javax.validation.constraints.NotBlank

class ItemSaveCommand(
    @NotBlank val title: String,
    @NotBlank val body: String
)